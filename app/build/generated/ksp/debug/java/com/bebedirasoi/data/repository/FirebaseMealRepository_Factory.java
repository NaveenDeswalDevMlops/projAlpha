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
public final class FirebaseMealRepository_Factory implements Factory<FirebaseMealRepository> {
  private final Provider<FirebaseFirestore> firestoreProvider;

  public FirebaseMealRepository_Factory(Provider<FirebaseFirestore> firestoreProvider) {
    this.firestoreProvider = firestoreProvider;
  }

  @Override
  public FirebaseMealRepository get() {
    return newInstance(firestoreProvider.get());
  }

  public static FirebaseMealRepository_Factory create(
      Provider<FirebaseFirestore> firestoreProvider) {
    return new FirebaseMealRepository_Factory(firestoreProvider);
  }

  public static FirebaseMealRepository newInstance(FirebaseFirestore firestore) {
    return new FirebaseMealRepository(firestore);
  }
}
