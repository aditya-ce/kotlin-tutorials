package com.example.superheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.example.superheroes.data.HeroesRepository.heroes
import com.example.superheroes.model.Hero

@Composable
fun HeroCard(
    modifier: Modifier = Modifier,
    hero: Hero
    ) {
    Card(
        elevation = CardDefaults
            .cardElevation(dimensionResource(R.dimen.card_elevation)),
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = dimensionResource(R.dimen.padding_medium),
                vertical = dimensionResource(R.dimen.padding_small)),
    ) {
        Row(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    stringResource(hero.nameRes),
                    style = MaterialTheme.typography.displaySmall,

                )
                Text(
                    stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
            Spacer(Modifier.size(dimensionResource(R.dimen.padding_medium)))
            Image(
                painter = painterResource(hero.imageRes),
                contentDescription = stringResource(hero.nameRes),
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(dimensionResource(R.dimen.image_size))
                    .clip(MaterialTheme.shapes.small)
            )
        }

    }
}


@Composable
fun HeroList(
    innerpadding: PaddingValues
) {
    LazyColumn(
        contentPadding = innerpadding
    ) {
        items(heroes) {
            hero ->
            HeroCard(hero = hero)
        }
    }
}