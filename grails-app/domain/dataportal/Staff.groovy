package dataportal

import com.sun.org.apache.xpath.internal.operations.Div

/**
 * Staff
 * A domain class describes the data object and it's mapping to the database
 */
class Staff {

    String number
    String name
    String position
    String email
    String phoneExtension
    String location
    Staff manager
    Programme programme
    Division division
    String bio
    String username
    String password
    boolean administrator

    /* Default (injected) attributes of GORM */
//	Long	id
//	Long	version

    /* Automatic timestamping of GORM */
//	Date	dateCreated
//	Date	lastUpdated

//	static	belongsTo	= []	// tells GORM to cascade commands: e.g., delete this object if the "parent" is deleted.
//	static	hasOne		= []	// tells GORM to associate another domain object as an owner in a 1-1 mapping
//	static	hasMany		= []	// tells GORM to associate other domain objects for a 1-n or n-m mapping
//	static	mappedBy	= []	// specifies which property should be used in a mapping 

    static mapping = {
    }

    static constraints = {
        number()
        name()
        position()
        email()
        phoneExtension()
        location()
        manager(nullable: true)
        programme(nullable: true)
        division()
        bio()
        username(unique: false)
        password(nullable: true)
        administrator()
    }

    /*
     * Methods of the Domain Class
     */

    @Override
    public String toString() {
        return "${name}";
    }
}
