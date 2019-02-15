package com.gokul.learningkotlin


data class myList(val title: String, val des :String,val resid:Int)


fun getsampleList() : List<myList>
{
    return listOf<myList>( myList("Item 1","my first list item",R.drawable.ic_water),
        myList("Item 2","my 2nd list item",R.drawable.walk_ic))

}