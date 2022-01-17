package br.com.pehenmo.gerenciador.decorators;

import br.com.pehenmo.gerenciador.controllers.ServletController;
import br.com.pehenmo.gerenciador.controllers.impl.AlteraEmpresaController;
import br.com.pehenmo.gerenciador.controllers.impl.ListaEmpresaController;
import br.com.pehenmo.gerenciador.controllers.impl.MostraEmpresaController;
import br.com.pehenmo.gerenciador.controllers.impl.NovaEmpresaController;
import br.com.pehenmo.gerenciador.controllers.impl.RemoveEmpresaController;
import br.com.pehenmo.gerenciador.utils.Constants;

public class ServletControllerDecorator {
	
	public static ServletController get(String acao) {
		var result = switch(acao) {
			case Constants.ACAO_LISTA_EMPRESA -> new ListaEmpresaController();
			case Constants.ACAO_NOVA_EMPRESA -> new NovaEmpresaController();
			case Constants.ACAO_ALTERAR_EMPRESA -> new AlteraEmpresaController();
			case Constants.ACAO_REMOVER_EMPRESA -> new RemoveEmpresaController();
			case Constants.ACAO_MOSTRA_EMPRESA -> new MostraEmpresaController();
			default -> throw new IllegalStateException("Unexpected value: " + acao);
		};
		
		return result;
	}

}
