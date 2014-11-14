package entities

class Contract {
    String          title
    String          registrationId
    String          notes
    
    String toString() {"$title: $registrationId"}
    
    static hasMany = [parties:ContractParty, accounts:Account]
    static constraints = {
        title               ()
        registrationId      ()
        accounts            ()
        parties             ()
        notes               (nullable:true)
    }
}
