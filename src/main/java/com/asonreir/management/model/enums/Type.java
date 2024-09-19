package com.asonreir.management.model.enums;

import lombok.Getter;

@Getter
public enum Type {
  INGRESO(0),
  EGRESO(1);
  private final int id;

  Type(int id) {
    this.id = id;
  }

  public static Type fromId(int id){
    for(Type type: values()){
      if(type.getId() == id){
        return type;
      }
    }
    throw new IllegalArgumentException("Id de type no encontrado: "+id);
  }
}
