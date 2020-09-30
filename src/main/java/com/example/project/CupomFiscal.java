package com.example.project;

public class CupomFiscal {

	private static boolean isEmpty(String input){
		if (input == null){
			return true;
		}
		
		if (input.equals("")){
			return true;
		}

		else{
			return false;
		}
	}	


	public static String Quebra_Linha = System.lineSeparator();

	public static String dadosLojaObjeto(Loja loja) {


		if (isEmpty(loja.getNomeLoja())){
			throw new RuntimeException ("O campo nome da loja é obrigatório");
		}

		if (isEmpty(loja.getLogradouro())){
			throw new RuntimeException ("O campo logradouro do endereço é obrigatório");
		}

		if(isEmpty(loja.getMunicipio())) {
			throw new RuntimeException("O campo município do endereço é obrigatório");
		}
		
		if(isEmpty(loja.getEstado())) {
			throw new RuntimeException("O campo estado do endereço é obrigatório");
		}
	
		if(isEmpty(loja.getCnpj()))
			throw new RuntimeException("O campo cnpj da loja é obrigatório");
	
		if(isEmpty(loja.getInscricaoEstadual())){
			throw new RuntimeException("O campo inscrição estadual da loja é obrigatório");
		}
		
		String _logradouro = loja.getLogradouro() + ", ";
		String _numero = (loja.getNumero() <= 0)? "s/n" : String.format("%d", loja.getNumero());
		String _complemento = isEmpty(loja.getComplemento())? "" : " " + loja.getComplemento();
		String _bairro = isEmpty(loja.getBairro())? "" : loja.getBairro() + " - ";
		String _municipio = loja.getMunicipio() + " - ";
		
		String _cep = isEmpty(loja.getCep())? "" : "CEP:" + loja.getCep();
		String _telefone = isEmpty(loja.getTelefone())? "" : "Tel " + loja.getTelefone();
		_telefone = (!_telefone.isEmpty() && !_cep.isEmpty())? " " + _telefone : _telefone;
		
		String _observacao = isEmpty(loja.getObservacao())? "" : loja.getObservacao();
						
		String _cnpj = "CNPJ: " + loja.getCnpj();
		String _inscricao_estadual = "IE: " + loja.getInscricaoEstadual();

		String dados_cupom = loja.getNomeLoja() + Quebra_Linha;
		dados_cupom += _logradouro + _numero + _complemento  + Quebra_Linha;
		dados_cupom += _bairro + _municipio + loja.getEstado() + Quebra_Linha;
		dados_cupom +=  _cep + _telefone + Quebra_Linha;
		dados_cupom +=  _observacao + Quebra_Linha;
		dados_cupom +=  _cnpj + Quebra_Linha;
		dados_cupom +=  _inscricao_estadual + Quebra_Linha;

		return dados_cupom;

	}

}
