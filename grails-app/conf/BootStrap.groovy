import dataportal.Category
import dataportal.Country
import dataportal.DataSource
import dataportal.DataType
import dataportal.Division
import dataportal.Programme
import dataportal.Staff
import dataportal.Theme
import org.apache.commons.lang.RandomStringUtils
import org.apache.commons.lang.StringUtils

class BootStrap {

    def grailsApplication

    def init = { servletContext ->
        println "Bootstrapping..."

        //division
        if (Division.list().size() == 0) {
            Division d = new Division()
            d.name = "Applied GeoScience and Technology Division"
            d.acronym = "AGTD"
            d.director = null
            d.save(flush: true, failOnError: true)
        }

        //programme
        if (Programme.list().size() == 0){
            def map = [:]
            map.put("Disaster Risk Reduction", "DRR")
            map.put("Water and Sanitation", "WSP")
            map.put("Geoscience for Development", "GSD")
            map.put("Technical Support Services", "TSS")
            map.each{k, v->
                Programme p = new Programme()
                p.setName(k)
                p.setAcronym(v)
                p.save(flush: true, failOnError: true)
            }
        }

        //staff
        if (Staff.list().size() == 0) {
            def managerMap = [:]
            String path = grailsApplication.mainContext.getResource('data/staff.xlsx').file.absolutePath
            new ExcelReader(path).eachLine([labels: true]) {
                if (Activeprofile.toString().trim().equals("1")) {
                    Staff s = new Staff()
                    s.number = Id.toString().trim()
                    String n = name
                    def t = n.split(",")
                    n = t[1] + " " + StringUtils.capitalise(t[0].toLowerCase())
                    s.name = n.trim()
                    String p = Position.toString().trim()
                    if (p.endsWith("-")) p = p.substring(0, p.length() - 1)
                    s.position = p
                    s.phoneExtension = Phone
                    s.email = Email.toString().trim().toLowerCase()
                    s.location = "Suva"
                    s.programme = Programme.findWhere(acronym: Programme1)
                    s.division = Division.list().get(0)
                    s.bio = "None"
                    s.username = n.trim().split(" ")[0].toLowerCase().trim()
                    int randomStringLength = 8
                    String charset = (('a'..'z') + ('A'..'Z') + ('0'..'9')).join()
                    String randomString = RandomStringUtils.random(randomStringLength, charset.toCharArray())
                    s.password = randomString
                    s.administrator = false
                    s.save(failOnError: true, flush: true)
                    String managerNumber = Manager
                    managerMap.put(s.number, managerNumber)
                }
            }
            //set director
            Division d = Division.list().get(0)
            d.setDirector(Staff.findByNumber("S0756"))
            d.save(flush: true)

            //set manager
            //println managerMap
            managerMap.each { k, v ->
                Staff s = Staff.findByNumber(k)
                Staff manager = Staff.findByNumber(v)
                //println s.name + " : " + manager.name
                s.setManager(manager)
                //s.email = s.email.toLowerCase().trim()
                s.save(flush: true)

            }
        }

        //theme
        if (Theme.list().size() == 0) {
            def map = [:]
            map.put("Disaster Risk Reduction", "DRR")
            map.put("Water and Sanitation", "WS")
            map.put("Deep Sea Minerals", "DSM")
            map.put("Climate Change Adaptation", "CCA")
            map.put("Ocean and Coastal", "OC")
            map.put("Information Technology", "ICT")
            map.put("Geothermal Energy", "GTE")
            map.put("GeoSurveys, Earth Resources", "GRE")

            map.each { k, v ->
                Theme t = new Theme()
                t.name = k
                t.acronym = v
                t.save(flush: true, failOnError: true)
            }
        }

        //datatype
        if (DataType.list().size() == 0) {
            def list = ["Geospatial Maps", "Documents", "Newsletters", "Videos", "Photos", "Animations"]
            list.each { type ->
                DataType dt = new DataType()
                dt.type = type
                dt.save(flush: true, failOnError: true)
            }
        }

        //countries
        if (Country.list().size() == 0) {
            def countries = ["AMERICAN_SAMOA", "PALAU", "TONGA", "COOK_ISLANDS", "KIRIBATI", "PITCAIRN", "TUVALU", "FIJI_ISLANDS", "MARSHALL_ISLANDS", "PNG", "NAURU", "SAMOA", "VANUATU", "FRENCH_POLYNESIA", "NEW_CALEDONIA", "SOLOMON_ISLANDS", " WALLIS_FUTUNA", "FSM", "NIUE", "TIMOR_LESTE", "GUAM", "NORTHERN_MARIANA_ISLANDS", "TOKELAU"]
            countries.sort().each {
                Country c = new Country()
                c.flag = it.toString().trim() + ".jpg"
                String cn = it.toString().trim().toLowerCase()
                cn = cn.replaceAll("_", " ")
                cn = StringUtils.capitaliseAllWords(cn)
                if (cn.equals("Png")) cn = "Papua New Guinea"
                if (cn.equals("Fsm")) cn = "FSM"
                c.setName(cn)
                c.save(flush: true, failOnError: true)
            }
        }

        //data sources
        if (DataSource.list().size() == 0){
            def map = [:]
            def url = [:]
            map.put("Pacific Disaster Net", "PDN")
            url.put("Pacific Disaster Net", "www.pacificdisaster.net")
            map.put("SOPAC Commission Virtual Library", "CommLib")
            url.put("SOPAC Commission Virtual Library", "ict.sopac.org/library")
            map.put("SPC GeoScience Division Virtual Library", "DivisionLib")
            url.put("SPC GeoScience Division Virtual Library", "ict.sopac.org/library")
            map.put("Pacific Water", "PW")
            url.put("Pacific Water", "www.pacificwater.org")
            map.put("Deep Sea Minerals Website", "DSM")
            url.put("Deep Sea Minerals Website", "www.sopac.org/dsm")
            map.put("Pacific Risk Information Systems", "PCRAFI")
            url.put("Pacific Risk Information Systems", "pcrafi.spc.int")
            map.put("PacGeo", "PacGeo")
            url.put("PacGeo", "www.pacgeo.org")
            map.put("SOPAC Geonetwork", "Geonetwork")
            url.put("SOPAC Geonetwork", "geonetwork.sopac.org")

            map.each {k, v->
                DataSource ds = new DataSource()
                ds.name = k
                ds.acronym = v
                ds.url = "http://" + url.get(k)
                ds.save(flush: true, failOnError: true)
            }
        }

        //categories
        if (Category.list().size() == 0){
            def l = []
            l.add("Bioata")
            l.add("Base Imageries")
            l.add("Administrative Boundaries")
            l.add("Bathymetric")
            l.add("Coastal")
            l.add("Topographic Maps Charts")
            l.add("Technical Reports")
            l.add("Training Reports")
            l.add("Training Material")
            l.add("Hydrographical")
            l.add("Hydrological")
            l.add("Trip Reports")
            l.add("Information Brochures")
            l.add("Cruise Reports")
            l.add("Raw Datasets")
            l.add("Data Release Reports")
            l.add("Bulletins")
            l.add("Land Use Cover")
            l.add("Outcomes and Proceeding")
            l.add("Agriculture")
            l.add("Maritime Boundaries")
            l.add("Economy")
            l.add("Elevation")
            l.add("Environment")
            l.add("Hazard")
            l.add("Exposure")
            l.add("Loss")
            l.add("Infrastructure")
            l.add("Oceans")
            l.add("Planning Cadastre")
            l.add("Utilities")
            l.add("Communications")
            l.add("Promotional Newlestter")
            l.add("Promotional Material")

            l.sort().each {
                Category c = new Category()
                c.name = it
                c.save(flush: true, failOnError: true)
            }
        }

    }
    def destroy = {
    }
}
