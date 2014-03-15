package entities

class CategoryType { 
    String      code
    String      title
    String      titleInt
    String      notes
    String      recStatus = "Active"
    Date        dateCreated
    Date        lastUpdated
    
    String toString() {"$code: $title/$titleInt"}
    
    static mapping = {
        code index:'AccOwnerTypeCode_Idx'
        title index:'AccOwnerTypeTitle_Idx'
        titleInt index:'AccOwnerTypeTitleInt_Idx'
    }    
    
    static constraints = {
        code        (unique:true, maxSize:6)
        title       (unique:true)
        titleInt    (unique:true)
        notes       (nullabe:true, maxSize:250, widget: 'textarea')
        recStatus   (editable:false, display:false, inList:["Active","Deleted"])
        dateCreated() // implied => editable:false, bindable: false
        lastUpdated() // implied => editable:false, bindable: false
    }
}
