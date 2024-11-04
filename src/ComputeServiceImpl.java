import java.util.ArrayList;
import java.util.UUID;

import com.example.grpc.ComputeProto.*;
import com.example.grpc.ComputeServiceGrpc.ComputeServiceImplBase;

import io.grpc.stub.StreamObserver;

public class ComputeServiceImpl extends ComputeServiceImplBase{

    private final ComputeEngineStorageSystem css;

    public ComputeServiceImpl() {
        this.css = new ComputeEngineStorageImplementation();
    }

    public void sendData(InputConfig request, StreamObserver<UUIDResponse> responseObserver) {
        try {
            UUID key = css.sendData(request);
            UUIDResponse response = UUIDResponse.newBuilder().setUuid(key.toString()).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    public void retrieveCharArr(UUIDRequest request, StreamObserver<CharArrayResponse> responseObserver) {
        try {
            char[] charArray = css.retrieveCharArr(UUID.fromString(request.getUuid()));
            CharArrayResponse.Builder responseBuilder = CharArrayResponse.newBuilder();
            for (char c : charArray) {
                responseBuilder.addCharArray(String.valueOf(c));
            }
            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    public void retrieveCharAl(UUIDRequest request, StreamObserver<CharArrayListResponse> responseObserver) {
        try {
            ArrayList<char[]> charAl = css.retrieveCharAl(UUID.fromString(request.getUuid()));
            CharArrayListResponse.Builder responseBuilder = CharArrayListResponse.newBuilder();
            for (char[] arr : charAl) {
                CharArrayResponse.Builder charArrayResponseBuilder = CharArrayResponse.newBuilder();
                for (char c : arr) {
                    charArrayResponseBuilder.addCharArray(String.valueOf(c));
                }
                responseBuilder.addCharArrayList(charArrayResponseBuilder.build());
            }
            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }
}