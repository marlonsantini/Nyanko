package fingerfire.com.nyanko.features.cats.ui.viewstate

import fingerfire.com.nyanko.features.cats.data.response.CatResponse

data class CatViewState(val sucess: List<CatResponse>? = null, val failure: Boolean = false)