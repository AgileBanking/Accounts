package entities

class PartyRole {
    String      role
    String      roleInt
    String      notes
    
    String toString() {"$role/$roleInt"}
    
    static constraints = {
        role    (unique:true)
        roleInt (uniqie:true)
        notes   (nullable:true)
    }
    
    static mappig = {
        order "role"
    }
}
