import java.util.ArrayList;
import java.util.UUID;


import com.example.grpc.ComputeServiceGrpc.ComputeServiceImplBase;
import com.example.grpc.Service.CSRetreiveAlRequest;
import com.example.grpc.Service.CSRetreiveAlResponse;
import com.example.grpc.Service.CSRetreiveArrRequest;
import com.example.grpc.Service.CSRetreiveArrResponse;
import com.example.grpc.Service.CSSendDataRequest;
import com.example.grpc.Service.CSSendDataResponse;

import io.grpc.stub.StreamObserver;

public class ComputeServiceImpl extends ComputeServiceImplBase{

    private final ComputeEngineStorageSystem css;

    public ComputeServiceImpl() {
        this.css = new ComputeEngineStorageImplementation();
    }
    @Override
    public void sendData(CSSendDataRequest request, StreamObserver<CSSendDataResponse> responseObserver) {
        try {
        	if(request.hasIntInput()) {
        		InputConfig input = new IntegerInputConfig(request.getIntInput());
                UUID key = css.sendData(input);
                CSSendDataResponse response = CSSendDataResponse.newBuilder().setUuid(key.toString()).build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
        	} else {
        		InputConfig fileInput = new FileInputConfig(request.getUserData());
        		UUID key = css.sendData(fileInput);  
        		CSSendDataResponse response = CSSendDataResponse.newBuilder().setUuid(key.toString()).build();
        		responseObserver.onNext(response);
                responseObserver.onCompleted();
        	  }
//        	String strRequest = request.toString();
//        	int intRequest = Integer.parseInt(strRequest);
        	
        } catch (Exception e) {
        	e.printStackTrace();
        	CSSendDataResponse response = CSSendDataResponse.newBuilder().setError(e.getMessage()).build();
    		responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
    @Override
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
        	e.printStackTrace();
        	CSRetreiveArrResponse response = CSRetreiveArrResponse.newBuilder().setError(e.getMessage()).build();
    		responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
    @Override
    public void retrieveCharAl(CSRetreiveAlRequest request, StreamObserver<CSRetreiveAlResponse> responseObserver) {
        try {
            ArrayList<char[]> charAl = css.retrieveCharAl(UUID.fromString(request.getUuid()));
            CSRetreiveAlResponse.Builder responseBuilder = CSRetreiveAlResponse.newBuilder();
            for (char[] arr : charAl) {
            	CSRetreiveAlResponse.Builder charAlResponseBuilder = CSRetreiveAlResponse.newBuilder();
                for (char c : arr) {
                    charAlResponseBuilder.addCharArrays(String.valueOf(c));
                }
                responseBuilder.addCharArrays(charAlResponseBuilder.toString());
            }
            responseObserver.onNext(responseBuilder.build());
            responseObserver.onCompleted();
        } catch (Exception e) {
        	e.printStackTrace();
        	CSRetreiveAlResponse response = CSRetreiveAlResponse.newBuilder().setError(e.getMessage()).build();
    		responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
    
  

      
  
}