import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;


import com.example.grpc.DataStorageImplementationServiceGrpc.DataStorageImplementationServiceImplBase;
import com.example.grpc.DataStore.DSRecieveDataRequest;
import com.example.grpc.DataStore.DSRecieveDataResponse;
import com.example.grpc.DataStore.DSSendDataResponse;
import com.example.grpc.DataStore.MkFileResponse;

import io.grpc.stub.StreamObserver;

public class DataStoreServiceImpl extends DataStorageImplementationServiceImplBase{

    private final DataStorageSystem dss;

    public DataStoreServiceImpl() {
        this.dss = new DataStorageImplementation();
    }

    public void sendData(InputConfig request, StreamObserver<DSSendDataResponse> responseObserver) {
        try {
            UUID key = dss.sendData(request);
            DSSendDataResponse response = DSSendDataResponse.newBuilder().setKey(key.toString()).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    public void recieveData(DSRecieveDataRequest request, StreamObserver<DSRecieveDataResponse> responseObserver) {
        try {
            ArrayList<Integer> intAl = dss.recieveData(UUID.fromString(request.getKey()));
            DSRecieveDataResponse.Builder responseBuilder = DSRecieveDataResponse.newBuilder();
            for (int i : intAl) {
                responseBuilder.setIntArrays(String.valueOf(i));
            }
            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    public void mkFile(ArrayList<char[]> request, StreamObserver<MkFileResponse> responseObserver) {
        try {
            File userFile = dss.mkFile(request);
            MkFileResponse.Builder responseBuilder = MkFileResponse.newBuilder();
            try (BufferedReader br = new BufferedReader(new FileReader(userFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                	MkFileResponse.Builder charArrayResponseBuilder = MkFileResponse.newBuilder();
                	charArrayResponseBuilder.setFile(line);
                	responseBuilder.setFile(userFile.getName());
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