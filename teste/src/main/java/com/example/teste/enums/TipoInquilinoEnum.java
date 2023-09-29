package com.example.teste.enums;

public enum TipoInquilinoEnum {
	
	    A("Aluguel"),
	    Q("Quitado");

	    private String TipoInqui;

	    TipoInquilinoEnum(String TipoInqui) {
	        this.TipoInqui = TipoInqui;
	    }

	    public String getTipoInqui() {
	        return TipoInqui;
	    }
	}

