package com.bebedirasoi.data.remote;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class RazorpayManager_Factory implements Factory<RazorpayManager> {
  @Override
  public RazorpayManager get() {
    return newInstance();
  }

  public static RazorpayManager_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static RazorpayManager newInstance() {
    return new RazorpayManager();
  }

  private static final class InstanceHolder {
    private static final RazorpayManager_Factory INSTANCE = new RazorpayManager_Factory();
  }
}
