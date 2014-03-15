package entities

class AccOwnerCategory {   
    CategoryType    categoryType 
    String          code
    String          title
    String          titleInt
    String          notes
    String          recStatus = "Active"
    Date            dateCreated
    Date            lastUpdated
    
    String toString() {"$categoryType:$code: $title/$titleInt"}
    
    static belongsTo = [accOwner:AccOwner]
    
    static mapping = {
        categoryType    index:'AccOwnerCategoryCode_Idx'
        code            index:'AccOwnerCategoryCode_Idx'
        
        title index:'AccOwnerCategoryTitle_Idx'
        titleInt index:'AccOwnerCategoryTitleInt_Idx'
    }    
    
    static constraints = {
        categoryType    ()
        code            (unique:true, maxSize:6)
        title           (unique:true)
        titleInt        (unique:true)
        notes           (nullabe:true, maxSize:250, widget: 'textarea')
        recStatus       (editable:false, display:false, inList:["Active", "Deleted"])
        dateCreated() // implied => editable:false, bindable: false
        lastUpdated() // implied => editable:false, bindable: false
    }
}