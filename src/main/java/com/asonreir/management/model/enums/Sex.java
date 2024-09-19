package com.asonreir.management.model.enums;

import lombok.Getter;

@Getter
public enum Sex {
  MALE(0),
  FEMALE(1);

  private final int id;

  Sex(int id) {
    this.id = id;
  }

  public static Sex fromId(int id){
      for(Sex sex : values()){
        if(sex.getId() == id){
          return sex;
        }
      }
    throw new IllegalArgumentException("Sexo inválido. id:" + id);
  }
}
