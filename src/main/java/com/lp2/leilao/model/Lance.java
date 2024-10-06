package com.lp2.leilao.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "lance")
public class Lance {

        @Id
        @Column(name = "lance_id", unique = true)
        private long id;
        @Column(name = "valor")
        private double valor;

        @ManyToOne
        @JoinColumn(name = "lote_id")
        private Lote lote;

        @ManyToOne
        @JoinColumn(name = "cliente_id")
        private Cliente cliente;

        public Lance() {
        }

        public Lance(long id, double valor, Cliente cliente) {
            this.id = id;
            this.valor = valor;
            this.cliente = cliente;
        }

}
