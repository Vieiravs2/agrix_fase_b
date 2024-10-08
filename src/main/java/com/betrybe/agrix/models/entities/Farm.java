package com.betrybe.agrix.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


/**
 * Farm Entity.
 */
@Entity
@Data
@Table(name = "farms")
public class Farm {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private double size;

  /**
   * Constructor vazio.
   */
  public Farm() {
  }

  /**
   * Constructor.
   */
  public Farm(Long id, String name, double size) {
    this.id = id;
    this.name = name;
    this.size = size;
  }
}