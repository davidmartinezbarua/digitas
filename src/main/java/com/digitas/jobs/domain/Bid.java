package com.digitas.jobs.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Bid {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;

        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "buyer_id")
        Buyer buyer;

        @JsonIgnore
        @ManyToOne
        @JoinColumn(name = "project_id")
        Project project;

        LocalDateTime bidAt = LocalDateTime.now();
        Double price = 0.0;


        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public Buyer getBuyer() {
                return buyer;
        }

        public void setBuyer(Buyer buyer) {
                this.buyer = buyer;
        }

        public Project getProject() {
                return project;
        }

        public void setProject(Project project) {
                this.project = project;
        }

        public LocalDateTime getBidAt() {
                return bidAt;
        }

        public void setBidAt(LocalDateTime bidAt) {
                this.bidAt = bidAt;
        }

        public Double getPrice() {
                return price;
        }

        public void setPrice(Double price) {
                this.price = price;
        }
}
