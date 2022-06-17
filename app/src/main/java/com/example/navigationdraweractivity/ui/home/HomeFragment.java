package com.example.navigationdraweractivity.ui.home;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleObserver;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.navigationdraweractivity.R;
import com.example.navigationdraweractivity.databinding.ActivityMainBinding;
import com.example.navigationdraweractivity.ui.kcal.KcalCustomAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FieldPath;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class HomeFragment extends Fragment {

    private FirebaseFirestore db;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<User> arrayList;
    private ArrayList<User2> arrayList2;
    private ProgressDialog progressDialog;
    private static final String TAG = "result";
    private ImageView load;

    //
    private String data_n, data_s;
    private int data_r;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetching data");
        progressDialog.show();

        recyclerView = v.findViewById(R.id.recyclerView_h);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<User>();
        arrayList2 = new ArrayList<User2>();
//        load = v.findViewById(R.id.r_image); //

        db = FirebaseFirestore.getInstance();

//        data_n = "20220608131831";
//
//        FirebaseStorage storage = FirebaseStorage.getInstance("gs://smart-refrigerator1.appspot.com");
//        StorageReference storageReference = storage.getReference();
//        StorageReference riverRef = storageReference.child("/" + data_n + ".jpg" );

//        data_r = Integer.parseInt(data_n) + 1;
//        File f = new File("gs://smart-refrigerator1.appspot.com/"+String.valueOf(data_r)+".jpg");
//        if(f.exists()){
//            data_n = String.valueOf(data_r);
//        }

//        riverRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//            @Override
//            public void onSuccess(Uri uri) {
//                Glide.with(getContext()).load(uri).into(load);
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//
//            }
//        });
//


        adapter = new CustomAdapter(arrayList,arrayList2,getActivity());
        recyclerView.setAdapter(adapter);
        EventChangeListener();


        return v;
    }

    private void EventChangeListener() {

        db.collection("present_foodlist").orderBy("id",Query.Direction.DESCENDING).limit(1)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                        if(error != null){
                            if(progressDialog.isShowing()){
                                progressDialog.dismiss();
                            }
                            Log.e("Firestore error", error.getMessage());
                            return;
                        }
                        for (DocumentChange dc : value.getDocumentChanges()) {
                            if (dc.getType() == DocumentChange.Type.ADDED) {
                                arrayList2.add(dc.getDocument().toObject(User2.class));
                                if(!arrayList2.get(0).getRottenapple().equals("0")){
                                    db.collection("foodlist").whereEqualTo("name", "썩은사과").limit(1)
                                            .addSnapshotListener(new EventListener<QuerySnapshot>() {
                                                @Override
                                                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                                                    if(error != null){
                                                        if(progressDialog.isShowing()){
                                                            progressDialog.dismiss();
                                                        }
                                                        Log.e("Firestore error", error.getMessage());
                                                        return;
                                                    }
                                                    for (DocumentChange dc : value.getDocumentChanges()){
                                                        if(dc.getType() == DocumentChange.Type.ADDED){
                                                            arrayList.add(dc.getDocument().toObject(User.class));
                                                        }
                                                        adapter.notifyDataSetChanged();
                                                        if(progressDialog.isShowing()){
                                                            progressDialog.dismiss();
                                                        }
                                                    }
                                                }

                                            });
                                }
                                if(!arrayList2.get(0).getPotato().equals("0")){
                                    db.collection("foodlist").whereEqualTo("name", "감자").limit(1)
                                            .addSnapshotListener(new EventListener<QuerySnapshot>() {
                                                @Override
                                                public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                                                    if(error != null){
                                                        if(progressDialog.isShowing()){
                                                            progressDialog.dismiss();
                                                        }
                                                        Log.e("Firestore error", error.getMessage());
                                                        return;
                                                    }
                                                    for (DocumentChange dc : value.getDocumentChanges()){
                                                        if(dc.getType() == DocumentChange.Type.ADDED){
                                                            arrayList.add(dc.getDocument().toObject(User.class));
                                                        }
                                                        adapter.notifyDataSetChanged();
                                                        if(progressDialog.isShowing()){
                                                            progressDialog.dismiss();
                                                        }
                                                    }
                                                }

                                            });
                                }
                                if(!arrayList2.get(0).getEgg().equals("0")){
                                    db.collection("foodlist").whereEqualTo("name", "계란").addSnapshotListener(new EventListener<QuerySnapshot>() {
                                        @Override
                                        public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                                            if(error != null){
                                                if(progressDialog.isShowing()){
                                                    progressDialog.dismiss();
                                                }
                                                Log.e("Firestore error", error.getMessage());
                                                return;
                                            }
                                            for (DocumentChange dc : value.getDocumentChanges()){
                                                if(dc.getType() == DocumentChange.Type.ADDED){
                                                    arrayList.add(dc.getDocument().toObject(User.class));
                                                }
                                                adapter.notifyDataSetChanged();
                                                if(progressDialog.isShowing()){
                                                    progressDialog.dismiss();
                                                }
                                            }

                                        }
                                    });
                                }
                                if(!arrayList2.get(0).getLeek().equals("0")){
                                    db.collection("foodlist").whereEqualTo("name", "대파").addSnapshotListener(new EventListener<QuerySnapshot>() {
                                        @Override
                                        public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                                            if(error != null){
                                                if(progressDialog.isShowing()){
                                                    progressDialog.dismiss();
                                                }
                                                Log.e("Firestore error", error.getMessage());
                                                return;
                                            }
                                            for (DocumentChange dc : value.getDocumentChanges()){
                                                if(dc.getType() == DocumentChange.Type.ADDED){
                                                    arrayList.add(dc.getDocument().toObject(User.class));

                                                }
                                                adapter.notifyDataSetChanged();
                                                if(progressDialog.isShowing()){
                                                    progressDialog.dismiss();
                                                }
                                            }

                                        }
                                    });
                                }
                                if(!arrayList2.get(0).getDonut().equals("0")){
                                    db.collection("foodlist").whereEqualTo("name", "도넛").addSnapshotListener(new EventListener<QuerySnapshot>() {
                                        @Override
                                        public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                                            if(error != null){
                                                if(progressDialog.isShowing()){
                                                    progressDialog.dismiss();
                                                }
                                                Log.e("Firestore error", error.getMessage());
                                                return;
                                            }
                                            for (DocumentChange dc : value.getDocumentChanges()){
                                                if(dc.getType() == DocumentChange.Type.ADDED){
                                                    arrayList.add(dc.getDocument().toObject(User.class));

                                                }
                                                adapter.notifyDataSetChanged();
                                                if(progressDialog.isShowing()){
                                                    progressDialog.dismiss();
                                                }
                                            }

                                        }
                                    });
                                }
                                if(!arrayList2.get(0).getGarlic().equals("0")){
                                    db.collection("foodlist").whereEqualTo("name", "마늘").addSnapshotListener(new EventListener<QuerySnapshot>() {
                                        @Override
                                        public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                                            if(error != null){
                                                if(progressDialog.isShowing()){
                                                    progressDialog.dismiss();
                                                }
                                                Log.e("Firestore error", error.getMessage());
                                                return;
                                            }
                                            for (DocumentChange dc : value.getDocumentChanges()){
                                                if(dc.getType() == DocumentChange.Type.ADDED){
                                                    arrayList.add(dc.getDocument().toObject(User.class));

                                                }
                                                adapter.notifyDataSetChanged();
                                                if(progressDialog.isShowing()){
                                                    progressDialog.dismiss();
                                                }
                                            }

                                        }
                                    });
                                }
                                if(!arrayList2.get(0).getPaprika().equals("0")){
                                    db.collection("foodlist").whereEqualTo("name", "빨간피망").addSnapshotListener(new EventListener<QuerySnapshot>() {
                                        @Override
                                        public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                                            if(error != null){
                                                if(progressDialog.isShowing()){
                                                    progressDialog.dismiss();
                                                }
                                                Log.e("Firestore error", error.getMessage());
                                                return;
                                            }
                                            for (DocumentChange dc : value.getDocumentChanges()){
                                                if(dc.getType() == DocumentChange.Type.ADDED){
                                                    arrayList.add(dc.getDocument().toObject(User.class));

                                                }
                                                adapter.notifyDataSetChanged();
                                                if(progressDialog.isShowing()){
                                                    progressDialog.dismiss();
                                                }
                                            }

                                        }
                                    });
                                }
                                if(!arrayList2.get(0).getApple().equals("0")){
                                    db.collection("foodlist").whereEqualTo("name", "사과").addSnapshotListener(new EventListener<QuerySnapshot>() {
                                        @Override
                                        public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                                            if(error != null){
                                                if(progressDialog.isShowing()){
                                                    progressDialog.dismiss();
                                                }
                                                Log.e("Firestore error", error.getMessage());
                                                return;
                                            }
                                            for (DocumentChange dc : value.getDocumentChanges()){
                                                if(dc.getType() == DocumentChange.Type.ADDED){
                                                    arrayList.add(dc.getDocument().toObject(User.class));

                                                }
                                                adapter.notifyDataSetChanged();
                                                if(progressDialog.isShowing()){
                                                    progressDialog.dismiss();
                                                }
                                            }

                                        }
                                    });
                                }
                                if(!arrayList2.get(0).getSpam().equals("0")){
                                    db.collection("foodlist").whereEqualTo("name", "스팸").addSnapshotListener(new EventListener<QuerySnapshot>() {
                                        @Override
                                        public void onEvent(@Nullable QuerySnapshot value, @Nullable FirebaseFirestoreException error) {
                                            if(error != null){
                                                if(progressDialog.isShowing()){
                                                    progressDialog.dismiss();
                                                }
                                                Log.e("Firestore error", error.getMessage());
                                                return;
                                            }
                                            for (DocumentChange dc : value.getDocumentChanges()){
                                                if(dc.getType() == DocumentChange.Type.ADDED){
                                                    arrayList.add(dc.getDocument().toObject(User.class));

                                                }
                                                adapter.notifyDataSetChanged();
                                                if(progressDialog.isShowing()){
                                                    progressDialog.dismiss();
                                                }
                                            }

                                        }
                                    });
                                }

                            }

                            adapter.notifyDataSetChanged();
                            if (progressDialog.isShowing()) {
                                progressDialog.dismiss();
                            }
                        }
                    }

                });

    }
}
