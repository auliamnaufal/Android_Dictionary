package com.auliamnaufal.dictionariesapi.data

import com.google.gson.annotations.SerializedName

data class DictionaryResponse(

	@field:SerializedName("DictionaryResponse")
	val dictionaryResponse: List<DictionaryResponseItem?>? = null
)

data class DefinitionsItem(
	@field:SerializedName("definition")
	val definition: String? = null,
)

data class MeaningsItem(

	@field:SerializedName("definitions")
	val definitions: List<DefinitionsItem?>? = null
)

data class DictionaryResponseItem(

	@field:SerializedName("phonetic")
	val phonetic: String? = null,

	@field:SerializedName("word")
	val word: String? = null,

	@field:SerializedName("meanings")
	val meanings: List<MeaningsItem?>? = null,
)
