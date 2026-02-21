package com.bebedirasoi.data.repository;

import com.google.firebase.firestore.FirebaseFirestore;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class FirebaseOrderRepository_Factory implements Factory<FirebaseOrderRepository> {
  private final Provider<FirebaseFirestore> firestoreProvider;

  public FirebaseOrderRepository_Factory(Provider<FirebaseFirestore> firestoreProvider) {
    this.firestoreProvider = firestoreProvider;
  }

  @Override
  public FirebaseOrderRepository get() {
    return newInstance(firestoreProvider.get());
  }

  public static FirebaseOrderRepository_Factory create(
      Provider<FirebaseFirestore> firestoreProvider) {
    return new FirebaseOrderRepository_Factory(firestoreProvider);
  }

  public static FirebaseOrderRepository newInstance(FirebaseFirestore firestore) {
    return new FirebaseOrderRepository(firestore);
  }
}
