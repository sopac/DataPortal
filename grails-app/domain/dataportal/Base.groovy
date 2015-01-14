package dataportal

/**
 * Base
 * A domain class describes the data object and it's mapping to the database
 */
class Base {

    /* Default (injected) attributes of GORM */
//	Long	id
//	Long	version

    //Base Metadata
    String identifier
    String title
    String description
    DataType dataType // Document, Newsletter, Video, Photo, GeoSpatial Map, Model Animation
    Theme theme
    static hasMany = [categories: Category, countries: Country, relatedDocuments: Base]
    String authors
    DataSource source
    Division division
    String keywords
    //Base relatedDocuments
    String externalUrl
    int year

    //Document/Newsletter
    Date dateCreated
    Date datePublished
    String fileName
    String fileSize
    boolean series
    String seriesInformation
    int noOfPages

    //Media - Video/Animation
    String playbackTime

    //Map
    String WMSLink
    String spatialPlatform //Geonode / GeoServer / OpenGeo

    //Photo

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

        identifier(unique: true)
        title()
        description(maxSize: 2500)
        dataType() // Document, Newsletter, Video, Photo, GeoSpatial Map, Model Animation
        theme()
        categories()
        countries()
        authors()
        source()
        division()
        keywords()
        externalUrl()
        year()
        dateCreated()
        datePublished()
        fileName()
        fileSize()
        series()
        seriesInformation()
        noOfPages()
        playbackTime()
        WMSLink()
        spatialPlatform() //Geonode / GeoServer / OpenGeo

    }

    /*
     * Methods of the Domain Class
     */

    @Override
    // Override toString for a nicer / more descriptive UI
    public String toString() {
        return "${title}";
    }
}
