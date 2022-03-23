package br.com.soc.sistema.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import br.com.soc.sistema.vo.ExameVo;

@WebService
@SOAPBinding(style = Style.RPC)
public interface WebServiceExames {
	@WebMethod
	public String buscarExame(String codigo);

	@WebMethod
	public void excluirExame(String codigo);

	@WebMethod
	public void editarExame(ExameVo exameVo);
}
