import java.util.ArrayList;
import java.util.UUID;


import com.example.grpc.ComputeServiceGrpc.ComputeServiceImplBase;
import com.example.grpc.Service.CSRetreiveAlRequest;
import com.example.grpc.Service.CSRetreiveAlResponse;
import com.example.grpc.Service.CSRetreiveArrRequest;
import com.example.grpc.Service.CSRetreiveArrResponse;
import com.example.grpc.Service.CSSendDataResponse;

import io.grpc.stub.StreamObserver;

public class ComputeServiceImpl extends ComputeServiceImplBase{

    private final ComputeEngineStorageSystem css;

    public ComputeServiceImpl() {
        this.css = new ComputeEngineStorageImplementation();
    }

    public void sendData(InputConfig request, StreamObserver<CSSendDataResponse> responseObserver) {
        try {
            UUID key = css.sendData(request);
            CSSendDataResponse response = CSSendDataResponse.newBuilder().setUuid(key.toString()).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    public void retrieveCharArr(CSRetreiveArrRequest request, StreamObserver<CSRetreiveArrResponse> responseObserver) {
        try {
            char[] charArray = css.retrieveCharArr(UUID.fromString(request.getUuid()));
            CSRetreiveArrResponse.Builder responseBuilder = CSRetreiveArrResponse.newBuilder();
            for (char c : charArray) {
                responseBuilder.setCharArray(String.valueOf(c));
            }
            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }

    public void retrieveCharAl(CSRetreiveAlRequest request, StreamObserver<CSRetreiveAlResponse> responseObserver) {
        try {
            ArrayList<char[]> charAl = css.retrieveCharAl(UUID.fromString(request.getUuid()));
            CSRetreiveAlResponse.Builder responseBuilder = CSRetreiveAlResponse.newBuilder();
            for (char[] arr : charAl) {
            	CSRetreiveAlResponse.Builder charAlResponseBuilder = CSRetreiveAlResponse.newBuilder();
                for (char c : arr) {
                    charAlResponseBuilder.setCharArrays(String.valueOf(c));
                }
                //responseBuilder.setCharArr(charAlResponseBuilder.build());
            }
            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();
        } catch (Exception e) {
            responseObserver.onError(e);
        }
    }
}