package com.amrib.graphql.model;

import graphql.schema.GraphQLInputType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressInput implements GraphQLInputType {

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "addressUpdate";
	}

	private Integer actorId;
	private String address;

}
