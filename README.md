URLAssignment Design Document

Youngmin Lee, 0928381
CSE403
=============

I used URL java library to check if the url is valid, to make canonicalized url, and to
compare two urls. When it creates an URL object with given string in URLModel, it will throw
exceptions if url is invalid. In URLModel, it will make a canonicalized url by creating a new
URL object with protocol, host, and file fields from the original URL object. URLs are compared
by using equals method from URL java library. During URLRunner is running, 
it gets canonicalized url and boolean if url is unique, only when source url is valid. 
Otherwise, it prints out error message.

//URLModel that stores an url with given string.
public URLModel(String urlString)

//return true if url is valid
public boolean isValid()

//return canonicalized url
public URL getCanonicalized()

//return true if no url in given list is equal to current url which is
//located in given index of the list.
public boolean isUnique(ArrayList<URL> list, URL current, int index)