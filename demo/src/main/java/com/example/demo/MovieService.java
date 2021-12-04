package com.example.demo;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class MovieService {

    public static final String COLLECTION_NAME = "Movies";

    public String saveMovie(Movie movie) throws ExecutionException,InterruptedException {
      Firestore dbFirestor = FirestoreClient.getFirestore();

      ApiFuture<WriteResult> collectionApiFuture = dbFirestor.collection(COLLECTION_NAME).document(movie.getName()).set(movie);

      return collectionApiFuture.get().getUpdateTime().toString();
    }
}
