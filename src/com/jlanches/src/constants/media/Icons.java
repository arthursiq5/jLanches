/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jlanches.src.constants.media;

import com.jlanches.src.constants.MediaExtensions;
import com.jlanches.src.constants.Paths;

/**
 *
 * @author arthur
 */
public enum Icons {

    SELECIONADO_64("icons8-selecionado-64", MediaExtensions.PNG),
    CANCELAR_64("icons8-cancelar-64", MediaExtensions.PNG),
    USUARIO_CANCEL_64("icons8-usuário-masculino-cancel-64", MediaExtensions.PNG),
    USUARIO_PLUS_64("icons8-usuário-masculino-plus-64", MediaExtensions.PNG),
    EDITAR_64("icons8-editar-arquivo-64", MediaExtensions.PNG),
    EXCLUIR_64("icons8-excluir-64", MediaExtensions.PNG),
    APAGAR_16("icons8-apagador-16", MediaExtensions.PNG),
    APAGAR_64("icons8-apagador-64", MediaExtensions.PNG),
    PESQUISAR_16("icons8-pesquisar-16", MediaExtensions.PNG),
    PESQUISAR_64("icons8-pesquisar-64", MediaExtensions.PNG),
    CHECK_64("icons8-selecionado-64", MediaExtensions.PNG),
    ADD_64("icons8-adicionar-64", MediaExtensions.PNG),
    ADD_16("icons8-adicionar-16", MediaExtensions.PNG),
    COIN_16("icons8-barato-2-16", MediaExtensions.PNG),
    COIN_64("icons8-barato-2-64", MediaExtensions.PNG),
    CREDIT_CARD_16("icons8-cartão-em-uso-16", MediaExtensions.PNG),
    CREDIT_CARD_64("icons8-cartão-em-uso-64", MediaExtensions.PNG),
    PAYMENT_CHECK_16("icons8-talão-de-cheques.-16", MediaExtensions.PNG),
    PAYMENT_CHECK_64("icons8-talão-de-cheques.-64", MediaExtensions.PNG),
    CASH_PAYMENT_16("icons8-dinheiro-na-mão-16", MediaExtensions.PNG),
    CASH_PAYMENT_64("icons8-dinheiro-na-mão-64", MediaExtensions.PNG),
    CLOCK_16("icons8-relógio-despertador-16", MediaExtensions.PNG),
    CLOCK_64("icons8-relógio-despertador-64", MediaExtensions.PNG),
    CLOCK_CONFIG_16("icons8-relógio-despertador-16-config", MediaExtensions.PNG),
    CLOCK_CONFIG_64("icons8-relógio-despertador-64-config", MediaExtensions.PNG),
    WATCH_TIME_16("icons8-assistir-16", MediaExtensions.PNG),
    WATCH_TIME_64("icons8-assistir-64", MediaExtensions.PNG),
    ICONE_DO_PROJETO("jlanches-icone", MediaExtensions.PNG),
    OPEN_FOLDER_64("icons8-abrir-pasta-64", MediaExtensions.PNG),
    OPEN_FOLDER_16("icons8-abrir-pasta-16", MediaExtensions.PNG),
    FILE_16("icons8-arquivo-de-fichas-16", MediaExtensions.PNG),
    FILE_64("icons8-arquivo-de-fichas-64", MediaExtensions.PNG),
    PEDIDO_ENTREGUE_16("icons8-pedido-entregue-16", MediaExtensions.PNG),
    PEDIDO_ENTREGUE_64("icons8-pedido-entregue-64", MediaExtensions.PNG),
    PHONE_16("icons8-telefone-sem-uso-16", MediaExtensions.PNG),
    PHONE_64("icons8-telefone-sem-uso-64", MediaExtensions.PNG),
    USERS_16("icons8-grupos-de-usuários-16", MediaExtensions.PNG),
    USERS_64("icons8-grupos-de-usuários-64", MediaExtensions.PNG),
    FILIAL_16("icons8-loja-16", MediaExtensions.PNG),
    FILIAL_64("icons8-loja-64", MediaExtensions.PNG);

    String path;
    private MediaExtensions extension;

    private Icons(String path, MediaExtensions extension) {
        this.path = path;
        this.extension = extension;
    }

    @Override
    public String toString() {
        return this.path;
    }

    public String getPath() {
        return this.path;
    }

    public String getFullPath() {
        return Paths.ICONS + this.path + this.extension;
    }
}
