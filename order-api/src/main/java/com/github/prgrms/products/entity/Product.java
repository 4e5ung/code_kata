package com.github.prgrms.products.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

import static com.google.common.base.Preconditions.checkArgument;
import static java.time.LocalDateTime.now;
import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;


@Getter
  @Setter
  @NoArgsConstructor(access = AccessLevel.PROTECTED)
  @Table(name = "products")
  @Entity
  public class Product {

    @Id
    @Column(name = "seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "product_id_seq")
    private Long seq;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "details", length = 1000)
    private String details;

    @Column(name = "review_count")
    private int reviewCount;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    public Product(String name, String details) {
      this(null, name, details, 0, null);
    }

    @Builder
    public Product(Long seq, String name, String details, int reviewCount, LocalDateTime createAt) {
      this.seq = seq;
      this.name = name;
      this.details = details;
      this.reviewCount = reviewCount;
      this.createAt = defaultIfNull(createAt, now());
    }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Product product = (Product) o;
    return Objects.equals(seq, product.seq);
  }




}