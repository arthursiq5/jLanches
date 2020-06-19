/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.constants;

/**
 *
 * @author arthur
 */
public enum Icons {
    
    SELECIONADO_64("icons8-selecionado-64"),
    CANCELAR_64("icons8-cancelar-64"),
    USUARIO_CANCEL_64("icons8-usuário-masculino-cancel-64"),
    USUARIO_PLUS_64("icons8-usuário-masculino-plus-64"),
    EDITAR_64("icons8-editar-arquivo-64"),
    EXCLUIR_64("icons8-excluir-64"),
    APAGAR_16("icons8-apagador-16"),
    APAGAR_64("icons8-apagador-64"),
    PESQUISAR_16("icons8-pesquisar-16"),
    PESQUISAR_64("icons8-pesquisar-64"),
    CHECK_64("icons8-selecionado-64"),
    ADD_64("icons8-adicionar-64.png"),
    ADD_16("icons8-adicionar-16.png"),
    COIN_16("icons8-barato-2-16.png"),
    COIN_64("icons8-barato-2-64.png"),
    CREDIT_CARD_16("icons8-cartão-em-uso-16.png"),
    CREDIT_CARD_64("icons8-cartão-em-uso-64.png"),
    PAYMENT_CHECK_16("icons8-talão-de-cheques.-16.png"),
    PAYMENT_CHECK_64("icons8-talão-de-cheques.-64.png"),
    CASH_PAYMENT_16("icons8-dinheiro-na-mão-16.png"),
    CASH_PAYMENT_64("icons8-dinheiro-na-mão-64.png");
    
    
    String path;
    
    private Icons(String path){
        this.path = path;
    }
    
    @Override
    public String toString(){
        return this.path;
    }
    
    public String getPath(){
        return this.path;
    }
}
