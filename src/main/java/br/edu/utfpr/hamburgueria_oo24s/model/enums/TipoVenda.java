package br.edu.utfpr.hamburgueria_oo24s.model.enums;

import br.edu.utfpr.hamburgueria_oo24s.model.Order;

public enum TipoVenda {
    BOLETO {
        @Override
        public Double calcularValorFinal(Order order) {
            return null;
        }
    },
    CARTAO_CREDITO {
        @Override
        public Double calcularValorFinal(Order order) {
            return null;
        }
    };

    public abstract Double calcularValorFinal(Order order);


}
