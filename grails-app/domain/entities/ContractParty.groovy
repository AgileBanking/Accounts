package entities

class ContractParty {
    String      type = "Person"
    String      party
    PartyRole   role
    String      notes
    
    String toString() {"$role: $party"}
    
    static belongsTo = [contract:Contract]
    
    static constraints = {
        type    (inList:["Person", "Legal Entity"])
        contract (nullable:false)
        role    (nullable:false)
        party   (unique:'contract')
        notes   (nullable:true)
    }
}
