import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData

object Utils {
    fun <T> getListItemLiveData(sourceLiveData: LiveData<List<T>>, index: Int): LiveData<T?> {
        val resultLiveData = MediatorLiveData<T?>()

        resultLiveData.addSource(sourceLiveData) { list ->
            if (index >= 0 && index < list.size) {
                resultLiveData.value = list[index]
            } else {
                // Handle the out-of-bounds case by setting value to null
                resultLiveData.value = null
            }
        }

        return resultLiveData
    }
}
