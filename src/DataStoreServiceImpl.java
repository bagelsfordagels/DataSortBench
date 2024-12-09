import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.example.grpc.DataStorageImplementationServiceGrpc.DataStorageImplementationServiceImplBase;
import com.example.grpc.DataStore.DSRecieveDataResponse;
import com.example.grpc.DataStore.DSSendDataResponse;
import com.example.grpc.DataStore.MkFileResponse;
import com.example.grpc.Service.CSRetreiveAlResponse;

import io.grpc.stub.StreamObserver;

public class DataStoreServiceImpl extends DataStorageImplementationServiceImplBase{

    private final DataStorageSystem dss;

    public DataStoreServiceImpl() {
        this.dss = new DSImpOptimization();
    }
    @Override
    public void sendData(com.example.grpc.DataStore.DSSendDataRequest request,
            io.grpc.stub.StreamObserver<com.example.grpc.DataStore.DSSendDataResponse> responseObserver) {
        try {
        	String strRequest = request.getFileInput();
        	InputConfig requestIC = new FileInputConfig(strRequest);
            UUID key = dss.sendData(requestIC);
            DSSendDataResponse response = DSSendDataResponse.newBuilder().setKey(key.toString()).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
        	e.printStackTrace();
        	DSSendDataResponse response = DSSendDataResponse.newBuilder().setError(e.getMessage()).build();
    		responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
    @Override
    public void recieveData(com.example.grpc.DataStore.DSRecieveDataRequest request,
            io.grpc.stub.StreamObserver<com.example.grpc.DataStore.DSRecieveDataResponse> responseObserver) {
        try {
        	//String strRequest = request.toString();
            ArrayList<Integer> intAl = dss.recieveData(UUID.fromString(request.getKey()));
            DSRecieveDataResponse.Builder responseBuilder = DSRecieveDataResponse.newBuilder();
            for (int i : intAl) {
                responseBuilder.setIntArrays(String.valueOf(i));
            }
            String strResponse = "";
            for(int i = 0; i < intAl.size(); i++) {
            	strResponse = strResponse + intAl.get(i);
            }
            DSRecieveDataResponse response = DSRecieveDataResponse.newBuilder().setIntArrays(strResponse).build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
        	e.printStackTrace();
        	DSRecieveDataResponse response = DSRecieveDataResponse.newBuilder().setError(e.getMessage()).build();
    		responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
    @Override
    public void mkFile(com.example.grpc.DataStore.MkFileRequest request,
            io.grpc.stub.StreamObserver<com.example.grpc.DataStore.MkFileResponse> responseObserver) {
        try {
        	ArrayList<char[]> charArrAl = new ArrayList<>();
        	for(int i = 0; i<request.getCharArraysCount(); i++) {
        		String s = request.getCharArrays(i);
        		char[] charArr = new char[s.length()];
        		charArr = s.toCharArray();
        		charArrAl.add(charArr);
        	}
            File userFile = dss.mkFile(charArrAl);
            MkFileResponse.Builder responseBuilder = MkFileResponse.newBuilder();
//            try {
            try (BufferedReader br = new BufferedReader(new FileReader(userFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                	MkFileResponse.Builder charArrayResponseBuilder = MkFileResponse.newBuilder();
                	charArrayResponseBuilder.addFile(line);
//                	responseBuilder.setFile(userFile.toString());
                }
            }catch(Exception e) {
            	e.printStackTrace();
            }
//            String strResponse = "";
//            try (BufferedReader br2 = new BufferedReader(new FileReader(userFile))){
//            	String line2;
//                while ((line2 = br.readLine()) != null) {
//                	strResponse = strResponse + line2;
//                }
//            }
                MkFileResponse response = MkFileResponse.newBuilder().addFile(request.getCharArrays(0)).build();
                for(int i = 1; i < request.getCharArraysCount(); i++) {
                	response.toBuilder().addFile(request.getCharArrays(i));
                }
                responseObserver.onNext(response);
                responseObserver.onCompleted();
//            } catch (IOException e) {
//            	System.out.println("Error while reading file in DataStoreServiceImpl");
//                e.printStackTrace();
//            }
        } catch (Exception e) {
        	System.out.print("In the MkFile for DSImpl");
        	e.printStackTrace();
        	MkFileResponse response = MkFileResponse.newBuilder().setError(e.getMessage()).build();
    		responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}