package boys.mtv.kotlin.movie.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "api_keys")
data class ApiKeyEntity (

    @Id
    val id : String

)