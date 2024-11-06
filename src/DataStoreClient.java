import java.util.concurrent.TimeUnit;

import com.example.grpc.DataStorageImplementationServiceGrpc;
import com.example.grpc.DataStorageImplementationServiceGrpc.DataStorageImplementationServiceBlockingStub;
import com.example.grpc.DataStore.DSRecieveDataRequest;
import com.example.grpc.DataStore.DSRecieveDataResponse;
import com.example.grpc.DataStore.DSSendDataRequest;
import com.example.grpc.DataStore.DSSendDataResponse;
import com.example.grpc.DataStore.MkFileRequest;
import com.example.grpc.DataStore.MkFileResponse;

import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;

public class DataStoreClient { // Boilerplate TODO: change to <servicename>Client
    private final DataStorageImplementationServiceBlockingStub blockingStub; // Boilerplate TODO: update to appropriate blocking stub

    public DataStoreClient(Channel channel) {
        blockingStub = DataStorageImplementationServiceGrpc.newBlockingStub(channel);  // Boilerplate TODO: update to appropriate blocking stub
    }

    // Boilerplate TODO: replace this method with actual client call/response logic
    public String Order() { 
    	DSSendDataRequest request = DSSendDataRequest.newBuilder().build();
        DSSendDataResponse response;
        try {
            response = blockingStub.sendData(request);
        } catch (StatusRuntimeException e) {
            e.printStackTrace();
            return null;
        }
        return response.getKey();  
    }
//    public String recieveDataOrder() { 
//    	DSRecieveDataRequest request = DSRecieveDataRequest.newBuilder().build();
//    	DSRecieveDataResponse response;
//        try {
//            response = blockingStub.recieveData(request);
//        } catch (StatusRuntimeException e) {
//            e.printStackTrace();
//            return null;
//        }
//        return response.getIntArrays();
//    }
//    public String mkFileOrder() { 
//    	MkFileRequest request = MkFileRequest.newBuilder().build();
//    	MkFileResponse response;
//        try {
//            response = blockingStub.mkFile(request);
//        } catch (StatusRuntimeException e) {
//            e.printStackTrace();
//            return null;
//        }
//        return response.getFile();
//    }
    public static void main(String[] args) throws Exception {
        String target = "localhost:50073";  // Boilerplate TODO: make sure the server/port match the server/port you want to connect to

        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
                .build();
        try {
            DataStoreClient client = new DataStoreClient(channel); // Boilerplate TODO: update to this class name
            client.Order();
        } finally {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}