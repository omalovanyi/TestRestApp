# TestRestApp [![Build Status](https://travis-ci.org/omalovanyi/TestRestApp.svg?branch=master)](https://travis-ci.org/omalovanyi/TestRestApp)

## Running TestRestApp locally
```
	git clone https://github.com/omalovanyi/TestRestApp.git
	cd TestRestApp
	vagrant up
```

## You can then access TestRestApp here: 
```
	http://192.168.33.10:8084/hello/contacts?nameFilter=all (all contacts)
	http://192.168.33.10:8084/hello/contacts?nameFilter=^.*[aeiufAEIUF].*$ (all contacts did not match with pattern)
	http://192.168.33.10:8084/hello/contacts?nameFilter=^.*[a-zA-Z].*$ (not found such contacts)	
```