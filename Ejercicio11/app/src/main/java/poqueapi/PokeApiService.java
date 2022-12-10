package poqueapi;

import com.example.ejercicio11.Pokemon;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokeApiService {
    String BASE_URL = "https://pokeapi.co/api/v2/";
    @GET("pokemon/{id}")
    Call<Pokemon> getPokemonById(@Path("id") String id);
}
