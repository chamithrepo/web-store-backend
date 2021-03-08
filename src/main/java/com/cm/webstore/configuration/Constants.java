package com.cm.webstore.configuration;

import static com.cm.webstore.configuration.Constants.Global.UTILITY_CLASS;


/**
 * @author Chamith_Madusanka
 *
 * Maintaining all the Constants needed for the application
 */
public final class Constants {

	
	/**
	 * Global Constants
	 * 
	 */
	public static final class Global {
		private Global() {
			throw new IllegalStateException(UTILITY_CLASS);
		}

		public static final String UTILITY_CLASS = "Utility class";
	}

	/**
	 * Request Mappings
	 * 
	 */
	public static final class RequestMappings {
		private RequestMappings() {
			throw new IllegalStateException(UTILITY_CLASS);
		}

		public static final String API = "/api";
		public static final String PRICE_ROOT_PATH = "api/price";
		public static final String PRICE_FOR_PRODCUCT = "/{id}/{units}";
		public static final String PRICE_LIST_FOR_PRODUCT = "/list/{id}";
		
		public static final String PRODUCT_ROOT_PATH = "api/products";
		public static final String PRODUCT = "/{id}";
	}

	/**
	 * Mime Types
	 * 
	 */
	public static final class MimeTypes {
		private MimeTypes() {
			throw new IllegalStateException(UTILITY_CLASS);
		}

		public static final String APPLICATION_JSON_VALUE = "application/json";
	}

	/**
	 * Data access layer/JPA constants
	 * 
	 */
	public static final class Dal {
		private Dal() {
			throw new IllegalStateException(UTILITY_CLASS);
		}

		public static final String PRODUCT_TABLE_NAME = "product";
		public static final String PRODUCT_ID = "id";
		public static final String PRODUCT_NAME = "name";
		public static final String CARTON_PRICE = "carton_price";
		public static final String UNITS_PER_CARTON = "units_per_carton";
		public static final String LABOUR_TAX = "labour_tax";
		public static final String CREATED_TS = "insert_ts";
		public static final String MODIFIED_TS = "modified_ts";
		public static final String MODIFIED_BY = "modified_by";
		public static final String CREATED_BY = "created_by";
	}

	/**
	 * Exception Messages
	 * 
	 */
	public static final class Exceptions {
		private Exceptions() {
			throw new IllegalStateException(UTILITY_CLASS);
		}

		public static final String PRODUCT_NOT_FOUND = "Product not found";

	}

}
