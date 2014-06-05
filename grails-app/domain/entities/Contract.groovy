package entities

class Contract {
    String          title
    String          registrationId
    String          notes
    
    String toString() {"$title: $registrationId"}
    
//    static hasMany = [parties:ContractParty]
    static constraints = {
        title               ()
        registrationId      ()
        parties             ()
        notes               (nullable:true)
    }
}
