package example

class KotlinDataUser {
	fun create(name: String, id: Int): Data {
		return Data(id, name);
	}
}