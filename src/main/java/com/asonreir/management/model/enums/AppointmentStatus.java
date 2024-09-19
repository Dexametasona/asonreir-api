package com.asonreir.management.model.enums;

public enum AppointmentStatus {
  PENDING(0),
  SUCCESS(1),
  MISSING(2);

  private final int id;

  AppointmentStatus(int id) {
    this.id = id;
  }

  public static AppointmentStatus fromId(int id){
    for(AppointmentStatus status: values()){
      return status;
    }
    throw new IllegalArgumentException("Id no existente, id:"+id);
  }
}
