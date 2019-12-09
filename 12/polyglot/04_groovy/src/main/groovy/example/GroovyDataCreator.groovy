package example

import groovy.transform.Canonical

@Canonical
class GroovyDataCreator {
	
	int firstId
	int lastId
	int repeateCount
	
	List<Tuple2<Integer, String>> create() {
		def res = []
		for(int i=firstId; i<=lastId; ++i) {
			for(def j=0; j<repeateCount; ++j) {
				res << new Tuple2(i, generator((('a'..'z')+('A'..'Z')+('0'..'9')), 10))
			}
		}
		res
	}
	
	def generator = { alphabet, charCount ->
		new Random(System.currentTimeMillis()).with {
		  (1..charCount).collect { alphabet[ nextInt( alphabet.size() ) ] }.join()
		}
	  }
}
