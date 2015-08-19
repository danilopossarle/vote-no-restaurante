package br.com.voteNoRestaurante.utils;

import java.util.List;

/**
 * Model para deserializar uma {@link List} de {@link VotoModel}
 * 
 * @author danilo.possarle
 */
public class VotosModelWrapper {
	
	private List<VotoModel> votosModel;

	/**
	 * @return the votosModel
	 */
	public List<VotoModel> getVotosModel() {
		return votosModel;
	}

	/**
	 * @param votosModel the votosModel to set
	 */
	public void setVotosModel(List<VotoModel> votosModel) {
		this.votosModel = votosModel;
	}
	
	

}
