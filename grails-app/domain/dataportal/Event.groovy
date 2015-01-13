package dataportal

/**
 * Event
 * A domain class describes the data object and it's mapping to the database
 */
class Event {

    String title
    String type
    String description
    Date startDate
    Date endDate
    String venue
    Country country
    String leadAgency
    String supportingAgencies
    String contactPerson
    int year
    String comments
    String url

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
        title()
        type(inList: ["Conference", "Workshop", "Meeting", "Training", "Online"])
        description(maxSize: 2500, nullable: true, blank: true)
        venue(nullable: true, blank: true)
        leadAgency(nullable: true, blank: true)
        supportingAgencies(nullable: true, blank: true)
        comments(nullable: true, blank: true, maxSize: 2500)
        contactPerson(nullable: true, blank: true)
        url(nullable: true, blank: true)
        year(nullable: true, blank: true)
    }

    /*
     * Methods of the Domain Class
     */
//	@Override	// Override toString for a nicer / more descriptive UI 
//	public String toString() {
//		return "${name}";
//	}
}
