package com.devstart.pokedex.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devstart.pokedex.R
import com.devstart.pokedex.ui.theme.PokeDexTheme

@Composable
fun AppPokemonType(
    @DrawableRes icon: Int,
    typeName: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
       Icon(
           modifier = Modifier.size(16.dp),
           painter = painterResource(id = icon),
           contentDescription = null
       )
        Text(
            modifier = Modifier.padding(start = 4.dp),
            text = typeName,
            fontSize = 12.sp,
            fontFamily = FontFamily(Font(R.font.roboto_bold_font))
        )
    }
}

@Composable
@Preview
fun AppPokemonTypePreview() {
    PokeDexTheme {
        AppPokemonType(
        icon = R.drawable.fire,
        typeName = "Fire"
        )
    }
}