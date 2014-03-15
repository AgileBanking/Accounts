package entities

class AccountType {
    String  title
    String  titleInt
    String  notes
    String  recStatus = "Active"
    Date    dateCreated = new Date()
    Date    lastUpdated = new Date()
    
    String toString() {"$title / $titleInt"}
    
    static constraints = {
        title       unique:true,  blank:false, size:2..40
        titleInt    unique:true,  blank:false, size:2..40
        notes       nullable:true, size:0..250, widget: 'textarea'
        recStatus   editable:false, display:false, inList:["Active", "Deleted"]
        dateCreated editable:false, format:'yyyy-mm-dd'
        lastUpdated editable:false, format:'yyyy-mm-dd'
    }
}
