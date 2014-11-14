package entities

class ContractParty {
    String      type = "Person"
    String      party
    PartyRole   role
    String      notes
    
    String toString() {"$role: $party"}
    
    static belongsTo = [contract:Contract, account:Account]
    
    static constraints = {
        type        (inList:["Person", "Legal Entity"])
        account     (nullable:true)
        contract    (nullable:true)
        role        (nullable:false)
        party       (unique:'contract')
        notes       (nullable:true)
    }
}
