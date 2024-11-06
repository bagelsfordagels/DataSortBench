import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import com.example.grpc.ComputeProto.CharArrayListResponse;
import com.example.grpc.ComputeProto.CharArrayResponse;
import com.example.grpc.ComputeProto.UUIDRequest;
import com.example.grpc.ComputeProto.UUIDResponse;
import com.example.grpc.DataStorageImplementationServiceGrpc.DataStorageImplementationServiceImplBase;

import io.grpc.stub.StreamObserver;

public class DataStoreServiceImpl extends DataStorageImplementationServiceImplBase{

    private final DataStorageSystem dss;

    public DataStoreServiceImpl() {
        this.dss = new DataStorageImplementation();
    }

    public void sendData(InputConfig request, StreamObserver<UUIDResponse> responseObserver) {
        try {
            UUID key = dss.sendData(request);
            UUIDResponse response = UUIDResponse.newBuilder().setUuid(key.toString()).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    public void recieveData(UUIDRequest request, StreamObserver<CharArrayResponse> responseObserver) {
        try {
            ArrayList<Integer> intAl = dss.recieveData(UUID.fromString(request.getUuid()));
            CharArrayResponse.Builder responseBuilder = CharArrayResponse.newBuilder();
            for (int i : intAl) {
                responseBuilder.addCharArray(String.valueOf(i));
            }
            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    public void mkFile(ArrayList<char[]> request, StreamObserver<CharArrayListResponse> responseObserver) {
        try {
            File userFile = dss.mkFile(request);
            CharArrayListResponse.Builder responseBuilder = CharArrayListResponse.newBuilder();
            try (BufferedReader br = new BufferedReader(new FileReader(userFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                	CharArrayResponse.Builder charArrayResponseBuilder = CharArrayResponse.newBuilder();
                	charArrayResponseBuilder.addCharArray(line);
                	responseBuilder.addCharArrayList(charArrayResponseBuilder.build());
                }
                responseObserver.onNext(responseBuilder.build());
                responseObserver.onCompleted();
            } catch (IOException e) {
            	System.out.println("Error while reading file in DataStoreServiceImpl");
                e.printStackTrace();
            }
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }
}