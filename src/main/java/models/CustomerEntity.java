package models;

/**
 * Correspond à un enregistrement de la table Customer
 */
public class CustomerEntity {
	// TODO : ajouter les autres propriétés
	private int customerId;
	private String name;
	private String addressLine1;
        private String email;

	public CustomerEntity(int customerId, String name, String addressLine1,String email) {
		this.customerId = customerId;
		this.name = name;
		this.addressLine1 = addressLine1;
                this.email = email;
	}

        public CustomerEntity() {
        }

    

	/**
	 * Get the value of customerId
	 *
	 * @return the value of customerId
	 */
	public int getCustomerId() {
		return customerId;
	}
        
         public void setCustomerId(int id ){
          
             this.customerId = id;

        }

	/**
	 * Get the value of name
	 *
	 * @return the value of name
	 */
	public String getName() {
		return name;
	}
        
         public void setName(String name ){
          
             this.name = name;

        }

	/**
	 * Get the value of addressLine1
	 *
	 * @return the value of addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}
        
        
         public void setAddressLine1(String addressLine1 ){
          
             this.addressLine1 = addressLine1;

        }
        

        public void setEmail(String email){
          
             this.email = email;

        }

        public String getEmail (){
            return this.email;
        }

}
