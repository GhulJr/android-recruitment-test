package dog.snow.androidrecruittest.data.model.type

abstract class BaseSimpleType<T>(open val value: T) {
    override fun toString(): String = value.toString()
}